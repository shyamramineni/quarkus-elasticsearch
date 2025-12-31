// java
package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class CmdExecutor {

    public record Result(int exitCode, String stdout, String stderr) {
    }

    public static Result run(String command, boolean usePowerShell) throws IOException, InterruptedException {
        String[] cmd;
        if (usePowerShell) {
            cmd = new String[] { "powershell.exe", "-NoProfile", "-NonInteractive", "-Command", command };
        } else {
            cmd = new String[] { "cmd.exe", "/c", command };
        }

        ProcessBuilder pb = new ProcessBuilder(cmd);
        Process p = pb.start();

        ExecutorService ex = Executors.newFixedThreadPool(2);
        try {
            Future<String> outF = ex.submit(streamReader(p.getInputStream()));
            Future<String> errF = ex.submit(streamReader(p.getErrorStream()));

            int code = p.waitFor();
            String out = safeGet(outF);
            String err = safeGet(errF);

            return new Result(code, out, err);
        } finally {
            ex.shutdownNow();
        }
    }

    private static Callable<String> streamReader(final InputStream is) {
        return () -> {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
                return br.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        };
    }

    private static String safeGet(Future<String> f) {
        try {
            return f.get();
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            return "";
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java org.example.CmdExecutor [--ps] <command...>");
            System.exit(2);
        }

        boolean usePs = false;
        String[] cmdParts;
        if ("--ps".equals(args[0])) {
            usePs = true;
            if (args.length < 2) {
                System.err.println("Provide a command after --ps");
                System.exit(2);
            }
            cmdParts = Arrays.copyOfRange(args, 1, args.length);
        } else {
            cmdParts = args;
        }

        String command = String.join(" ", cmdParts);
        try {
            Result r = run(command, usePs);
            System.out.println("Exit code: " + r.exitCode);
            if (!r.stdout.isEmpty()) {
                System.out.println("STDOUT:");
                System.out.println(r.stdout);
            }
            if (!r.stderr.isEmpty()) {
                System.out.println("STDERR:");
                System.out.println(r.stderr);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Execution failed: " + e.getMessage());
            System.exit(1);
        }
    }
}
