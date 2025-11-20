package frc.robot.subsystems.arm;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import frc.robot.RobotContainer;

public class ArmCommands {
    public static Command getSetTargetAngleCommand() {
        return new FunctionalCommand(
                () -> Arm.getPosition(),
                ()-> ArmConstants.MOTOR.set(Arm.pidController().calculate(ArmConstants.CANCODER.getPosition(), 67)),
                () ->,
                () ->,
                RobotContainer.ARM
        );
    }
}
