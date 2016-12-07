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
    //@ ensures \old(getStatus())==LampOptions.OFF ==> getStatus()==LampOptions.LOW;
    //@ ensures \old(getStatus())==LampOptions.LOW ==> getStatus()==LampOptions.MEDIUM;
    //@ ensures \old(getStatus())==LampOptions.MEDIUM ==> getStatus()==LampOptions.HIGH;
    //@ ensures \old(getStatus())==LampOptions.HIGH ==> getStatus()==LampOptions.OFF;
    public void changeStatus() {
        assert status == LampOptions.OFF || status == LampOptions.LOW || status == LampOptions.MEDIUM || status == LampOptions.HIGH : "Lamp has to have a valid status";
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