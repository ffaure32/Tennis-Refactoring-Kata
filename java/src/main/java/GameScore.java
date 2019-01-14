public enum GameScore {
    LOVE,
    FIFTEEN,
    THIRTY,
    FORTY {
        @Override
        public String equalityScore() {
            return EQUALITY_DEUCE;
        }
    };

    public static final String EQUALITY_DEUCE = "Deuce";
    public static final String EQUALITY_STANDARD_SUFFIX = "-All";

    public String standardScore() {
        String enumName = this.name().toLowerCase();
        return Character.toUpperCase(enumName.charAt(0)) + enumName.substring(1);
    }

    public String equalityScore() {
        return standardScore()+ EQUALITY_STANDARD_SUFFIX;
    }

    public static GameScore fromIndex(int index) {
        if(index>=3) {
            return GameScore.FORTY;
        }
        return GameScore.values()[index];
    }
}
