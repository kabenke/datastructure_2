import java.util.*;

public class Bird
{
   private final long id;
   private String name;
   private double rarity;
   private long maximumLifeSpan;
   private long estimatedAge;
   private double latitude;
   private double langitude;
   private boolean isGhost;

   public Bird(String name , double rarity , long maximumLifeSpan , long estimatedAge , double latitude, double langitude )
   {
       this.id=computeID();
       this.name = name ;
       this.rarity=rarity;
       this.maximumLifeSpan=maximumLifeSpan;
       this.estimatedAge=estimatedAge;
       this.langitude=langitude;
       this.latitude=latitude;
       this.isGhost=isGhost();
   }

   public long computeID()
   {

     return Long.parseLong(UUID.randomUUID().toString());
   }
    public boolean isGhost()
   {
     return this.maximumLifeSpan<this.estimatedAge;
   }
   public String kindOfRarity()
   {
      if (this.rarity <= 0.5) {
        return "regulär Seltenheit";
      }
      else if (this.rarity>=0.5 && this.rarity<=0.7) {
        return "seltenen Vogel";
      }
      else{
           return "außergewöhnlich-seltenen Vogel";  /*Wir gehen davon aus das die Raritätsschritt respektiert werden*/
      }
   }

   public double getEstimatedLifeTime()
   {
     if (this.isGhost()) {
        return this.estimatedAge-this.maximumLifeSpan;
     }
     else
     {
       return this.maximumLifeSpan-this.estimatedAge;
     }
   }

   public boolean isInGermany()
   {
      return ((this.latitude >= 47.41) && (this.latitude <= 5.99)) ||((this.langitude >= 54.91) && (this.langitude <= 14.99));
   }

   public double getLatitudeDistance(Bird other)
   {
      return this.latitude - other.getLatitude();
   }

   public void setName(String name)
   {
     this.name = name;
   }
   public void setRarity(double rarity)
   {
     this.rarity = rarity;
   }
   public void setMaximumLifeSpan(long maximumLifeSpan)
   {
     this.maximumLifeSpan=maximumLifeSpan;
   }
   public void setEstimatedAge(long estimatedAge)
   {
    this.estimatedAge=estimatedAge;
   }

   public String getName()
   {
      return this.name;
   }
   public double getRarity()
   {
      return this.rarity;
   }
   public long getMaximumLifeSpan()
   {
      return this.maximumLifeSpan;
   }
   public long getEstimatedAge()
   {
     return this.estimatedAge;
   }
   public long getID()
   {
     return this.id;
   }
   public void setLatitude(double latitude)
   {
    this.latitude = latitude;
   }
   public void setLangitude(double langitude)
   {
    this.langitude = langitude;
   }
    public double getLatitude()
   {
      return this.latitude;
   }
   public double getLangitude()
   {
     return this.langitude;
   }

   /*Bird(String name , double rarity , long maximumLifeSpan , long estimatedAge , double latitude, double langitude*/

    public String toString()
    {
       return "Bird \t"+this.getName()+" ID \t"+this.getID()+" rarity \t"+this.getRarity()+" maximumLifeSpan \t"+this.getMaximumLifeSpan()+" estimatedAge \t"+this.getEstimatedAge()+
       " Latitude \t"+this.getLatitude()+" Langitude \t"+this.getLangitude();}

       public void print()
       {
        System.out.println(this.toString());
       }

}
