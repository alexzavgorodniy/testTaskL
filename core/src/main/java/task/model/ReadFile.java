package task.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "readfile")
public class ReadFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "path")
    private String path;

    @Column(name = "line_count")
    private Integer lineCount;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "readfile", orphanRemoval = true)
//    private List<Line> lines = new ArrayList<>();

    protected ReadFile() {
    }

    public ReadFile(String name) {
        this.name = Objects.requireNonNull(name, "Name of file cannot be NULL!");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getLineCount() {
        return lineCount;
    }

    public void setLineCount(Integer lineCount) {
        this.lineCount = lineCount;
    }

//    public List<Line> getLines() {
//        return lines;
//    }
//
//    public void setLines(List<Line> lines) {
//        this.lines = lines;
//    }
}
