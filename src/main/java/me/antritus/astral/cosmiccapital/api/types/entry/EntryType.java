package me.antritus.astral.cosmiccapital.api.types.entry;

@SuppressWarnings("unused")
public enum EntryType {
	ADD(0),
	REMOVE(1),
	RESET(2),
	SET(3)
	;
	private final int id;

	EntryType(int id){
		this.id = id;
	}

	public int id(){
		return id;
	}
}
