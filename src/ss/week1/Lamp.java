<<<<<<< HEAD
package ss.week1;

public class Lamp {
	public Lamp() {
		this.status = LampOptions.off;
	}

	private LampOptions status;
	
	public LampOptions getStatus() {
		return status;
	}

	public void changeStatus() {
		switch (status) {
			case off:
				status = LampOptions.low;
				break;
			case low:
				status = LampOptions.medium;
				break;
			case medium:
				status = LampOptions.high;
				break;
			case high:
				status = LampOptions.off;
				break;
		}
	}

	public enum LampOptions {
		off,
		low,
		medium,
		high
	}
}
=======
package ss.week1;

public class Lamp {
	public Lamp() {
		this.status = LampOptions.off;
	}

	private LampOptions status;
	
	public LampOptions getStatus() {
		return status;
	}

	public void changeStatus() {
		switch (status) {
			case off:
				status = LampOptions.low;
				break;
			case low:
				status = LampOptions.medium;
				break;
			case medium:
				status = LampOptions.high;
				break;
			case high:
				status = LampOptions.off;
				break;
		}
	}

	public enum LampOptions {
		off,
		low,
		medium,
		high
	}
}
>>>>>>> branch 'master' of https://github.com/Simon70/module-2.git
