package subway.view;

public enum Message {
    MAIN_MENU("\n## 메인 메뉴를 선택하세요."),
    SEARCH_TYPE("\n## 경로 기준을 선택하세요."),
    DEPARTURE("\n## 출발역을 입력하세요."),
    DESTINATION("\n## 도착역을 입력하세요.");

    private final String text;

    Message(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }
}