package proxy;

public class Agent implements Person {
    private Actor actor;
    private String before;
    private String after;

    public Agent(Actor actor, String before, String after) {
        this.actor = actor;
        this.before = before;
        this.after = after;
    }

    @Override
    public void speak() {
        System.out.println("before actor speak,Agent say:"+before);
        actor.speak();
        System.out.println("after actor speak,Agent say:"+after);
    }
}
