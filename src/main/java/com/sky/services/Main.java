package com.sky.services;

/**
 * Created by Jitin on 06/03/2017.
 */
public class Main {



        public static void main(String[] args) {

            String serverName = "NO-VALUE";

            switch (args.length) {
                case 2:

                    System.setProperty("server.port", args[1]);

                case 1:
                    serverName = args[0].toLowerCase();
                    break;

                default:
                    usage();
                    return;
            }

            if (serverName.equals("registration") || serverName.equals("reg")) {
                RegistryServer.main(args);
            } else if (serverName.equals("location")) {
                LocationServer.main(args);
            } else if (serverName.equals("catalog")) {
                CatalogServer.main(args);
            }else if (serverName.equals("web")) {
                WebServer.main(args);
            }

            else {
                System.out.println("Unknown server type: " + serverName);
                usage();
            }
        }

        protected static void usage() {
            System.out.println("Usage: java -jar ... <server-name> [server-port]");
            System.out.println(
                    "     where server-name is 'reg', 'registration', " + "'accounts' or 'web' and server-port > 1024");
        }

}
