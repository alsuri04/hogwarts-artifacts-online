package edu.tcu.cs.hogwartsartifactsonline.artifact;

import java.util.List;
import org.springframework.stereotype.Service;

import edu.tcu.cs.hogwartsartifactsonline.artifact.utils.IdWorker;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ArtifactService {

    private final ArtifactRepository artifactRepository;

    private final IdWorker idWorker;

    public ArtifactService(ArtifactRepository artifactRepository, IdWorker idWorker) {
        this.artifactRepository = artifactRepository;
        this.idWorker = idWorker;
    }

    public Artifact findById(String artifactId){
        return this.artifactRepository.findById(artifactId)
            .orElseThrow(() -> new ArtifactNotFoundException(artifactId));
    }

    public List<Artifact> findAll(){
        return this.artifactRepository.findAll();
    }

    public Artifact save(Artifact newArtifact) {
        newArtifact.setId(idWorker.nextId() + "");
        return this.artifactRepository.save(newArtifact);
    }

    public Artifact update(String artifactId, Artifact update){
        return this.artifactRepository.findById(artifactId)
                .map(oldArtifact -> {
                    oldArtifact.setName(update.getName());
                    oldArtifact.setDescription(update.getDescription());
                    oldArtifact.setImageURL(update.getImageURL());
                    Artifact updatedArtifact = this.artifactRepository.save(oldArtifact);
                    return updatedArtifact;
                })
                .orElseThrow(() -> new ArtifactNotFoundException(artifactId));
    }
    
}
