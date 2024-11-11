package by.ruslan.radzevich.task4;


import jdk.tools.jlink.plugin.Plugin;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

@Mojo(name = "start program")
public class MyMavenPlugin extends AbstractMojo {

    @Parameter(property = "className")
    private String className;
    @Parameter(property = "path")
    private String path;
    @Parameter(property = "pathToRoot")
    private String pathToRoot;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if (path != null || className != null || pathToRoot != null) {
            Process p;
            System.out.println("  java -cp " + pathToRoot + " " + "." + className);
            try {
                p = Runtime.getRuntime().exec(new String[]{
                        "java",
                        "-cp",
                        pathToRoot,
                        path + "." + className
                });
                String line;

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while ((line = bufferedReader.readLine()) != null)
                    System.out.println("[Output] " + line);

                BufferedReader err = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                while ((line = err.readLine()) != null)
                    System.out.println("[Err] " + line);

                p.waitFor();

            } catch (IOException | InterruptedException e) {
                Logger.getLogger(Plugin.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            System.out.println("Parameter not found");
        }
    }
}
