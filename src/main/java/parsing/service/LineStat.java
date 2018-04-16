package parsing.service;

import parsing.model.Line;

class LineStat {

    Line lineStatistics(Line lineOfText) {
        Integer lineLength = 0;
        Integer longestWord = 0;
        Integer shortestWord = 100;
        String[] words = lineOfText.getTitle().split("[^a-zA-Z\']");
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            lineLength += word.length();
            if (word.length() > longestWord) {
                longestWord = word.length();
            }
            if (word.length() < shortestWord) {
                shortestWord = word.length();
            }
        }
        lineOfText.setLongestWord(longestWord);
        lineOfText.setShortestWord(shortestWord);
        lineOfText.setLineLength(lineOfText.getTitle().length());
        lineOfText.setAverageWordLength(lineLength / words.length);
        return lineOfText;
    }
}
