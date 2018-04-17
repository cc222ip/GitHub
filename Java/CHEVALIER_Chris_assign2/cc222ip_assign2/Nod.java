package cc222ip_assign2;

class Nod { // Uses in 'HashWordSet' class.
	Word value; // Stock the word and the next value.
	Nod next = null;
	
	public Nod(Word w) { value = w; } // 'Nod' constructor.
	
	public String toString() { return value.toString(); }
}
