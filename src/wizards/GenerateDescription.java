package wizards;

import java.util.Random;

public class GenerateDescription {
  static String answer;
  static Random rand = new Random();

  public static String display() {
    answer = randomDescription();
    return answer;
  }

  private static String randomDescription() {
    int random = 1 + rand.nextInt((10-1) + 1);
    System.out.println(random);

    String total = "";

    String a = "";
    String b = "";
    String c = "";

    if (random == 1) {
    	a = "A furious rumble resounds in the area as stones come clattering through the doorway, along with a thick cloud of rock dust. The room beyond is filled with rubble.";
    }

    if (random == 2) {
    	a = "This chamber served as an armory for some group of creatures. Armor and weapon racks line the walls and rusty and broken weapons litter the floor.";
    }

    if (random == 3) {
    	a = "There's a hiss as you open this door, and you smell a sour odor, like something rotten or fermented. Inside you see a small room lined with dusty shelves, crates, and barrels.";
    }

    if (random == 4) {
    	a = "A horrendous, overwhelming stench wafts from the room before you. Small cages containing small animals and large insects line the walls.";
    }

    if (random == 5) {
    	a = "A stone throne stands on a foot-high circular dais in the center of this cold chamber. The throne and dais bear the simple adornments of patterns of crossed lines.";
    }

    if (random == 6) {
        a = "A modest overgrown boulder in a foggy morass marks the entrance to this dungeon. Beyond the overgrown boulder lies a modest, ragged room. It's covered in remains, rat droppings and bat droppings.";
    }

    if (random == 7) {
    	a = "A small graveyard in a somber grove marks the entrance to this room. It's covered in puddles of water, dirt and roots.";
    }

    if (random == 8) {
        a = "An altar in the center is covered in runes, some of which are glowing.";
    }

    if (random == 9) {
        a = "There is a crypt followed by a large dark room. It's covered in crawling insects, moss and small bones.";
    }

    if (random == 10) {
        a = "A waterfall marks the entrance to this dungeon. Beyond the waterfall lies a grand, broken room.";
    }

    random = 1 + rand.nextInt((10-1) + 1);
    System.out.println(random);

    if (random == 1) {
    	b = "A liquid-filled pit extends to every wall of this chamber. The liquid lies about 10 feet below your feet and is so murky that you can't see its bottom";
    }

    if (random == 2) {
    	b = "Fire crackles and pops in a small cooking fire set in the center of the room. The smoke from a burning rat on a spit curls up through a hole in the ceiling.";
    }

    if (random == 3) {
    	b = "A flurry of bats suddenly flaps through the doorway, their screeching barely audible as they careen past your heads";
    }

    if (random == 4) {
    	b = "You open the door, and the reek of garbage assaults your nose. Looking inside, you see a pile of refuse and offal that nearly reaches the ceiling. ";
    }

    if (random == 5) {
    	b = "You gaze into the room and hundreds of skulls gaze coldly back at you. They're set in niches in the walls in a checkerboard pattern, each skull bearing a half-melted candle on its head.";
    }

    if (random == 6) {
    	b = "You pass many different passages, most of which probably lead to other depths of this dungeon. You eventually make it to what is likely the final room. A mysterious wooden door blocks your path.";
    }

    if (random == 7) {
        b = "A twisted trail leads downwards and soon you enter a damp area. Piles and piles of gold lie in the center, several skeletons lie next to it.";
    }

    if (random == 8) {
        b = "You see a fallen tree that lies a narrow, timeworn room. Your torch allows you to see remnants of sacks, crates and caskets, worn and absorbed by time itself.";
    }

    if (random == 9) {
        b = "A twisted trail leads passed broken and pillaged tombs and soon you enter a worn area. The room is filled with lifelike statues of terrified people.";
    }

    if (random == 10) {
        b = "A stone throne stands on a foot-high circular dais in the center of this cold chamber. The throne and dais bear the simple adornments of patterns of crossed lines.";
    }

    random = 1 + rand.nextInt((10-1) + 1);
    System.out.println(random + "\n");

    if (random == 1) {
    	c = "But you see something ahead. it is a door that is stuck. Use an attack or spell to try and unlock it?";
    }

    if (random == 2) {
    	c = "A direct path lies ahead. But you sense a dark, overwhelming power ahead. Do you want to take this path?";
    }

    if (random == 3) {
    	c = "Two paths lie ahead. There is a safe route, as you sense no danger. You feel fear from sensing the other path.";
    }

    if (random == 4) {
    	c = "There is a wall to climb. One that requires great strength. Are you up for the challenge, or seek an alternative path?";
    }

    if (random == 5) {
    	c = "You seem to be at a dead end... Attempt to make a path with attacks or magic, or turn back around?";
    }

    if (random == 6) {
        c = "Further ahead are two paths, but the right is a dead end. Its twisted trail leads passed lost treasuries, unknown rooms and armories and soon you enter a crumbled area.";
    }

    if (random == 7) {
        c = "You eventually make it to what is likely the final room. However a door made of solid metal blocks your path. ";
    }

    if (random == 8) {
        c = "You pass various different rooms and countless passages, most lead to nowhere or back to this same path. However now you hear footsteps trailing...";
    }

    if (random == 9) {
        c = "A massive granite door blocks your path. Messages in strange languages are all over it, somehow untouched by time and the elements.";
    }

    if (random == 10) {
        c = "Dried blood splatters are all over a blocked entrance in front of you. The situation gives you the creeps. Do you proceed?";
    }
    total = a + "\n" + b + "\n" + c + "\n";
    return total;
  }
}
