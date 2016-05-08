package dias.m.yuri.fivespace.model;

/**
 * Holds a reference to the descriptionID, the image and the name of the fact.
 * Created by Yuri on 07-May-16.
 */
public class SpaceFact {
    private String name;

    private int descriptionID;

    private int photoID;

    public SpaceFact(String name, int descriptionID, int photoID) {
        this.name = name;
        this.descriptionID = descriptionID;
        this.photoID = photoID;
    }

    public SpaceFact(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return ((SpaceFact) o).getName().equals(this.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDescriptionID() {
        return descriptionID;
    }

    public void setDescriptionID(int descriptionID) {
        this.descriptionID = descriptionID;
    }

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }
}
