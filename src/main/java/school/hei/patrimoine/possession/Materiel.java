package school.hei.patrimoine.possession;

import school.hei.patrimoine.NotImplemented;
import school.hei.patrimoine.methods.ConvertirInstant;

import java.time.Instant;

public final class Materiel extends Possession {
  private final double tauxDAppreciationAnnuelle;

  public Materiel(String nom, Instant t, int valeurComptable, double tauxDAppreciationAnnuelle) {
    super(nom, t, valeurComptable);
    this.tauxDAppreciationAnnuelle = tauxDAppreciationAnnuelle;
  }

  @Override
  public double valeurComptableFuture(Instant tFutur) {
    ConvertirInstant convertirInstant = new ConvertirInstant();
    int nombreDAnnee = convertirInstant.extraireLAnneeDIstant(tFutur) - convertirInstant.extraireLAnneeDIstant(t);
    return valeurComptable + (tauxDAppreciationAnnuelle * nombreDAnnee);
  }
}
