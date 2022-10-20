package tn.esprit.rh.achat.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Fournisseur implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFournisseur;
	private String code;
	private String libelle;
	@Enumerated(EnumType.STRING)
	private CategorieFournisseur  categorieFournisseur;
	@OneToMany(mappedBy="fournisseur")
	@JsonIgnore
	private Set<Facture> factures;
    @ManyToMany
    @JsonIgnore
    private Set<SecteurActivite> secteurActivites;
    @OneToOne(cascade= CascadeType.ALL,fetch=FetchType.EAGER)
    private DetailFournisseur detailFournisseur;
	public Fournisseur() {
		super();
	}
	public Fournisseur(String code, String libelle, CategorieFournisseur categorieFournisseur, Set<Facture> factures,
			Set<SecteurActivite> secteurActivites, DetailFournisseur detailFournisseur) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.categorieFournisseur = categorieFournisseur;
		this.factures = factures;
		this.secteurActivites = secteurActivites;
		this.detailFournisseur = detailFournisseur;
	}
	public Fournisseur(Long idFournisseur, String code, String libelle, CategorieFournisseur categorieFournisseur,
			Set<Facture> factures, Set<SecteurActivite> secteurActivites, DetailFournisseur detailFournisseur) {
		super();
		this.idFournisseur = idFournisseur;
		this.code = code;
		this.libelle = libelle;
		this.categorieFournisseur = categorieFournisseur;
		this.factures = factures;
		this.secteurActivites = secteurActivites;
		this.detailFournisseur = detailFournisseur;
	}
	public Long getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(Long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public CategorieFournisseur getCategorieFournisseur() {
		return categorieFournisseur;
	}
	public void setCategorieFournisseur(CategorieFournisseur categorieFournisseur) {
		this.categorieFournisseur = categorieFournisseur;
	}
	public Set<Facture> getFactures() {
		return factures;
	}
	public void setFactures(Set<Facture> factures) {
		this.factures = factures;
	}
	public Set<SecteurActivite> getSecteurActivites() {
		return secteurActivites;
	}
	public void setSecteurActivites(Set<SecteurActivite> secteurActivites) {
		this.secteurActivites = secteurActivites;
	}
	public DetailFournisseur getDetailFournisseur() {
		return detailFournisseur;
	}
	public void setDetailFournisseur(DetailFournisseur detailFournisseur) {
		this.detailFournisseur = detailFournisseur;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
	
}
