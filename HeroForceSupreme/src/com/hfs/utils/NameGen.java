package com.hfs.utils;

import java.util.Random;

/**
 * @author Matt
 *
 */
/**
 * @author Matt
 *
 */
public class NameGen {
	
	// class attributes
	private String name = ""; // hero name
	private int prefixIndex = 0;
	private int suffixIndex = 0;
	
	// utility variables - general
	private Random random = new Random(); // random number generator
	
	// Hero Name Generator - constants 
	private static final String[] HERO_NAME_PREFIX = {"Tank", "Missle", "Book", "Crunch", "Pink", "Blade", "Day", "Lung", "Kidney", "Horse", "Rhino", "Reindeer", "Junk", "Spleen", "Large", "Carrot", "Tomato", "Titanium", "Helium", "Hydrogen", "Xeon", "Mercury", "Nancy", "Shine", "Sun", "Moon", "Uncle", "Peace", "Flame", "Mushroom", "Truth", "Punch", "Kick", "Karate", "Bruise", "Vertex", "Vortex", "Bun", "Hot", "Warm", "Cold", "Grease", "Breeze", "Wind", "Cloud", "Space", "Star", "Bull", "Blizzard", "Rocket", "Jet", "Thief", "Crook", "Toot", "Bum", "Bam", "Off", "Patch", "Leotard", "Burrito", "Priest", "Nun", "Man", "Woman", "Girl", "Boy", "Broom", "Freedom", "Day", "Night", "Sword", "Laser", "Plasma", "Jam", "Foot", "Zebra", "Lion", "Panther", "Sloth", "Frog", "Coffee", "Energy", "Gnu", "Emu", "Toe", "Snow", "Cheese", "Nebula", "Saturn", "Big", "Small", "Yule", "Down", "Gravy", "Smart", "Winkie", "Mango", "Mind", "Fork", "Spoon", "Bacon", "Vegan", "Ramen", "Sushi", "Spaghetti", "Zoo", "Karma", "Good", "Para", "Edge"};
	private static final String[] VILLAIN_NAME_PREFIX = {"Evil", "Octopus", "Squid", "Mattress", "Brown", "Fudge", "Hades", "Blood", "Bung", "Stab", "Vein", "Brain", "Fire", "Magma", "Sulfur", "Acid", "Fungus", "Dookie", "Kill", "Knife", "Bald", "Grudge", "Machete", "Small", "Dim", "Crack", "Wart", "Goiter", "Gout", "Chum", "Gray", "Grey", "Donkey", "Butcher", "Jester", "Oil", "Python", "Bone", "Sinew", "Virus", "Mold", "Mildew", "Flea", "Parasite", "Dinosaur", "Dynamite", "Exploder", "Robot", "Bot", "Bad", "Pain", "Cyber", "Bolt", "Enchant", "Mirage", "Lynx", "Bark", "Chop", "Boil", "Goon", "Cleaver", "Berzerk", "Lash", "Dino", "Pork", "Panda", };
	
	private static final String[] HERO_NAME_SUFFIX = {" Man", "man", " Boy", "boy", " Woman", " Girl", "girl", "tron", "Tooth", " of Good", " the Good", " the White", " the Boon", " Supreme", " the Bold", " the Brave", " the Pure", " the Righteous", " Steel", " of Purity", " of Bravery", " the Merry"};
	private static final String[] VILLAIN_NAME_SUFFIX = {"tor", "noid", " Man", "man", " Woman", " Girl", "girl", " Tooth", "saur", "ix", "atrix", "charge", "cron", "crux", " Pain", " Scientist", " of Evil", " Evil", " the Evil", " of Pain", " the Virus", " the Mean", " the Menacing", " the Vengeful", " the Brooding", " the Black", " the Mangy", " of Doom", " the Evil Knight", " the Ghost", " the Ethereal", " the Bane", " the Insane", " the Vile", " Blaze"};
	
	public String generateName(Boolean type) {
		// uses GameVars.HERO or GameVars.VILLAIN to generate the given type
		if (type) {
			// generate a hero if true
			prefixIndex = random.nextInt(HERO_NAME_PREFIX.length);
			suffixIndex = random.nextInt(HERO_NAME_SUFFIX.length);
			name = HERO_NAME_PREFIX[prefixIndex] + HERO_NAME_SUFFIX[suffixIndex];
		} else {
			// generate a villain if false
			prefixIndex = random.nextInt(VILLAIN_NAME_PREFIX.length);
			suffixIndex = random.nextInt(VILLAIN_NAME_SUFFIX.length);
			name = VILLAIN_NAME_PREFIX[prefixIndex] + VILLAIN_NAME_SUFFIX[suffixIndex];
		}
		return name;
	}
}
