import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main implements ProjectComponent {
    private Project project;

    public Main(Project project) {
        this.project = project;
    }

    @Override
    public void projectOpened() {
        File file = new File(project.getBasePath() + "/.git");
        if (!file.exists()) {
            try {
                Process process = Runtime.getRuntime().exec("konsole -e /home/majesta/IdeaProjects/autoGit/src/init.sh " + project.getBasePath());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void projectClosed() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
        try {
            Process process = Runtime.getRuntime().exec("konsole -e /home/majesta/IdeaProjects/autoGit/src/commit.sh " + project.getBasePath() + " " + dateFormat.format(new Date()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
