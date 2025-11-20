package frc.robot.subsystems.arm;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    public Arm() {
    }

    public static Angle getPosition() {
        return ArmConstants.CANCODER.getAbsolutePosition().getValue();
    }

    public static PIDController pidController(double kp, double ki, double kd) {
        return new PIDController(kp, ki, kd);
    }
}
