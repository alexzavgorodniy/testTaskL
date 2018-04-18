package task.service;

import task.model.Line;

class LineStatistics {

    Line lineStatistics(Line lineOfText) {
        Integer lineLength = 0;
        Integer longestWord = 0;
        Integer shortestWord = Integer.MAX_VALUE;
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
        lineOfText.setShortestWord(shortestWord == Integer.MAX_VALUE ? 0 : shortestWord);
        lineOfText.setLineLength(lineOfText.getTitle().length());
        lineOfText.setAverageWordLength(lineLength == 0 ? 0 : lineLength / words.length);
        return lineOfText;
    }
}
