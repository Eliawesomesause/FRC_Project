package frc.robot.subsystems.arm;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Arm extends SubsystemBase {
    private final TalonFX motor = ArmConstants.MOTOR;
    private final VoltageOut voltageRequest = new VoltageOut(0).withEnableFOC(ArmConstants.FOC_ENABLED);

    public Arm() {
    }

    void setTargetAngle(double targetAngle) {
        setTargetVoltage(calculatePIDOutput(targetAngle));
    }

    void setTargetState(ArmConstants.ArmState state) {
        setTargetAngle(state.targetAngle);
    }


    void stopMotor() {
        motor.stopMotor();
    }

    private double calculatePIDOutput(double targetAngle) {
        return ArmConstants.PID_CONTROLLER.calculate(getCurrentAngle(), targetAngle);
    }

    private double getCurrentAngle() {
        return ArmConstants.ANGLE_STATUS_SIGNAL.refresh().getValueAsDouble();
    }

    private void setTargetVoltage(double voltage) {
        motor.setControl(voltageRequest.withOutput(voltage));
    }
}
