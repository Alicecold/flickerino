package se.alicedarner.flickerino;


/* Maybe could use Shared Preferences instead */
class SearchSettings {
    private static boolean useCommons = false;

    static boolean useCommons() {
        return useCommons;
    }

    static void setUseCommons(boolean value) {
        useCommons = value;
    }
}
