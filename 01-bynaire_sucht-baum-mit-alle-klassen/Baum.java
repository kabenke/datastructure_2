public class Baum
{
  private float maximalHoehe;

  public Baum(float m)
  {
    setMaximumHoehe(m);
  }

  public void setMaximumHoehe(float m)
  {
    this.maximalHoehe = m;
  }
  public String getName()
  {
    return this.maximalHoehe;
  }
}
