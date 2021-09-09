package s22;

public class Ex1EntityDemo {
  //======================================
  static class Entity {
    // TODO
    public Entity() {
      // TODO
    }

    public String getValue() {
      return null; // TODO
    }

    public void setValue(String value) {
      // TODO
    }

    public void setListener(ValueChangedListener listener) {
      // TODO
    }
  }
  //======================================
  public interface ValueChangedListener {
    void onValueChanged(Entity e); 
  }
  //======================================
  // TODO
  // static class MyListener .... 
  
  //======================================
  public static void main(String[] args) {
    /* Please uncomment..
    Entity entity = new Entity();
    ValueChangedListener listener;
    listener = new MyListener();
    entity.setValue("abcd");
    entity.setListener(listener);
    entity.setValue("toto");
    entity.setValue("titi");
    */
  }
  
  /* Affichage lors de l'exécution : 
     An entity changed its value to: toto
     An entity changed its value to: titi
   */
}
