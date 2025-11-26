package frc.robot.subsystems.arm;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Arm extends SubsystemBase {
    private final TalonFX motor = ArmConstants.MOTOR;
    private final VoltageOut voltageRequest = new VoltageOut(0).withEnableFOC(ArmConstants.FOC_ENABLED);

    public Arm() {
    }

    void setTargetAngleDegrees(double targetAngle) {
        setTargetVoltage(calculatePIDOutput(targetAngle));
    }

    double calculatePIDOutput(double targetAngle) {
        return ArmConstants.PID_CONTROLLER.calculate(getCurrentAngleDegrees(), targetAngle);
    }

    double getCurrentAngleDegrees() {
        return ArmConstants.ANGLE_STATUS_SIGNAL.refresh().getValueAsDouble();
    }

    void setTargetVoltage(double voltage) {
        motor.setControl(voltageRequest.withOutput(voltage));
    }
    
    void stopMotor() {
        motor.stopMotor();
    }
}
