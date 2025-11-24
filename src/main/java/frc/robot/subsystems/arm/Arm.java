package frc.robot.subsystems.arm;

import com.ctre.phoenix6.controls.VoltageOut;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    public Arm() {
    }

    private final VoltageOut voltageRequest = new VoltageOut(0).withEnableFOC(ArmConstants.FOC_ENABLED);

    public Angle getPosition() {
        return ArmConstants.CANCODER.getAbsolutePosition().getValue();
    }

    public void setTargetAngle(double setPoint) {
        setTargetVoltage(doPIDCalculations(setPoint));
    }

    public double getAngleAsDouble() {
        return ArmConstants.ANGLE_STATUS_SIGNAL.refresh().getValueAsDouble();
    }

    public double doPIDCalculations(double setPoint) {
        return ArmConstants.PID_CONTROLLER.calculate(getAngleAsDouble(), setPoint);
    }

    void setTargetVoltage(double voltage) {
        ArmConstants.MOTOR.setControl(voltageRequest.withOutput(voltage));
    }

    void  stopMotor() {
        ArmConstants.MOTOR.stopMotor();
    }
}
