package lasermaze.view;

public enum TyleType {

    EMPTY ("resources/tiles/empty.png"), LASER("resources/tiles/laser.png"), MIRROR("resources/tiles/mirror.png");

    private String pictureFile;

    private TyleType(String pictureFile) {
        this.pictureFile = pictureFile;
    }

    public String getPictureFile() {
        return pictureFile;
    }
}
