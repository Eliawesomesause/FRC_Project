package frc.robot.subsystems.arm;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    public Arm() {
    }

    public Angle getPosition() {
        return ArmConstants.CANCODER.getAbsolutePosition().getValue();
    }

    public double getAngleAsDouble() {
        return ArmConstants.ANGLE_STATUS_SIGNAL.refresh().getValueAsDouble();
    }

    public void doPIDCalculations() {
        ArmConstants.MOTOR.set(ArmConstants.PID_CONTROLLER.calculate(getAngleAsDouble(), 67));
    }
}
