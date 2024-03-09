package edu.tcu.cs.hogwartsartifactsonline.artifact;

import java.io.Serializable;

import edu.tcu.cs.hogwartsartifactsonline.wizard.Wizard;
import edu.tcu.cs.hogwartsartifactsonline.wizard.dto.WizardDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity

public class Artifact implements Serializable {

    @Id
    private String id;

    private String name;

    private String description;

    private String imageURL;

    @ManyToOne
    private Wizard owner;

    public Artifact() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Wizard getOwner() {
        return this.owner;
    }

    public void setOwner(Wizard owner) {
        this.owner = owner;
    }

}
