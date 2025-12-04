package frc.robot.subsystems.wheel;


import com.ctre.phoenix6.controls.VoltageOut;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Wheel extends SubsystemBase {
    private final VoltageOut voltageRequest = new VoltageOut(0).withEnableFOC(WheelConstants.FOC_ENABLED);

    public Wheel() {
    }

    private void wheelCollect() {
        WheelConstants.MOTOR.setVoltage(11.69);
    }

    private void wheelEject() {
        WheelConstants.MOTOR.setVoltage(-11.69);
    }


    void setTargetVoltage(double voltage) {
        WheelConstants.MOTOR.setControl(voltageRequest.withOutput(voltage));
    }
}

