package ludito.demo_transaction.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @JsonIgnore
  @Column(name = "created_by")
  private String createdBy;

  @Column(name = "created")
  private LocalDateTime created;

  @JsonIgnore
  @Column(name = "modified_by")
  private String modifiedBy;

  @Column(name = "modified")
  private LocalDateTime modified;

  @PrePersist
  public void onPrePersist() {
    created = LocalDateTime.now();
    modified = LocalDateTime.now();
  }

  @PreUpdate
  public void onPreUpdate() {
    modified = LocalDateTime.now();
  }

  @PreRemove
  public void onPreRemove() {
    modified = LocalDateTime.now();
  }
}