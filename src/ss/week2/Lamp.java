package ss.week2;

public class Lamp {
	
	private /*@ spec_public @*/ LampOptions status;
	
	//@ assignable this.status;
	//@ ensures this.status == LampOptions.OFF;
	public Lamp() {
		this.status = LampOptions.OFF;
	}
	
	//@ pure
	public LampOptions getStatus() {
		return status;
	}

	//@ ensures this.status != \old(status);
	public void changeStatus() {
		switch (status) {
			case OFF:
				status = LampOptions.LOW;
				break;
			case LOW:
				status = LampOptions.MEDIUM;
				break;
			case MEDIUM:
				status = LampOptions.HIGH;
				break;
			case HIGH:
				status = LampOptions.OFF;
				break;
		}
	}

	public enum LampOptions {
		OFF,
		LOW,
		MEDIUM,
		HIGH
	}
}