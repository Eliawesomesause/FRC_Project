package frc.robot.subsystems.wheel;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Wheel extends SubsystemBase {
    public Wheel() {
    }
    private void wheelCollect(){
        WheelConstants.MOTOR.setVoltage(11.69);
    }

    private void wheelEject(){
        WheelConstants.MOTOR.setVoltage(-11.69);
    }

    void setTargetVoltage(double voltage){
        WheelConstants.MOTOR.setControl(WheelConstants.voltageRequest.withOutput(voltage));
    }
}

