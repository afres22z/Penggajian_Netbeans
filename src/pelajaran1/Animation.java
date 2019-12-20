package pelajaran1;

/**
 *
 * @author usu
 */
public enum Animation {

    /**
     * animasi dari kiri
     */
    SHOW_FROM_LEFT("SHOW_FROM_LEFT"),
    /**
     * animasi dari kanan 
     */
    SHOW_FROM_RIGHT("SHOW_FROM_RIGHT"),
    /**
     * animasi dari atas 
     */
    SHOW_FROM_TOP("SHOW_FROM_TOP"),
    /**
     * animasi dari bawah 
     */
    SHOW_FROM_BOTTOM("SHOW_FROM_BOTTOM"),
    /**
     * tak ada animasi
     */
    NO_ANIMATION("NO_ANIMATION"),
    /**
     * animasi ke kiri
     */
    HIDE_TO_LEFT("HIDE_TO_LEFT"),
    /**
     * animasi ke kanan
     */
    HIDE_TO_RIGHT("HIDE_TO_RIGHT"),
    /**
     * animasi ke atas
     */
    HIDE_TO_TOP("HIDE_TO_TOP"),
    /**
     * animasi ke bawah
     */
    HIDE_TO_BOTTOM("HIDE_TO_BOTTOM");
    private String animatedMethode;

    private Animation(String animatedMethode) {
        this.animatedMethode = animatedMethode;
    }

    public String getAnimatedMethode() {
        return animatedMethode;
    }

    @Override
    public String toString() {
        return getAnimatedMethode();
    }
}
