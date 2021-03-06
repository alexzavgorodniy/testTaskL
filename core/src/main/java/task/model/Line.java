package task.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "line")
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", length = 600000)
    private String title;

    @Column(name = "longest_word")
    private Integer longestWord;

    @Column(name = "shortest_word")
    private Integer shortestWord;

    @Column(name = "line_length")
    private Integer lineLength;

    @Column(name = "average_word_length")
    private Integer averageWordLength;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "readfile_id")
    private ReadFile readfile;*/

    @Column(name="readfile_id")
    private Integer readfileId;

    public Integer getReadfileId() {
        return readfileId;
    }

    public void setReadfileId(Integer readfileId) {
        this.readfileId = readfileId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLongestWord() {
        return longestWord;
    }

    public void setLongestWord(Integer longestWord) {
        this.longestWord = longestWord;
    }

    public Integer getShortestWord() {
        return shortestWord;
    }

    public void setShortestWord(Integer shortestWord) {
        this.shortestWord = shortestWord;
    }

    public Integer getLineLength() {
        return lineLength;
    }

    public void setLineLength(Integer lineLength) {
        this.lineLength = lineLength;
    }

    public Integer getAverageWordLength() {
        return averageWordLength;
    }

    public void setAverageWordLength(Integer averageWordLength) {
        this.averageWordLength = averageWordLength;
    }
/*
    public ReadFile getReadfile() {
        return readfile;
    }

    public void setReadfile(ReadFile readfile) {
        this.readfile = readfile;
    }*/
}
