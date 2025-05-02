package subway.view;

public enum Message {
    MAIN_MENU("\n## 메인 화면\n1. 경로 조회\nQ. 종료"),
    SEARCH_TYPE("\n## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기"),
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