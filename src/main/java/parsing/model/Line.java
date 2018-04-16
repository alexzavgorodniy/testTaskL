package parsing.model;

public class Line {

    private Integer id;

    private String title;

    private Integer longestWord;

    private Integer shortestWord;

    private Integer lineLength;

    private Integer averageWordLength;

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
}
