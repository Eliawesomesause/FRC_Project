package frc.robot.subsystems.arm;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import frc.robot.RobotContainer;

public class ArmCommands {
    public static Command getSetTargetAngleCommand(double setPoint) {
        return new FunctionalCommand(
                () -> RobotContainer.ARM.setTargetAngle(setPoint),
                () -> RobotContainer.ARM.setTargetAngle(setPoint) ,
                (Interrupted) -> RobotContainer.ARM.stopMotor() ,
                () -> false,
                RobotContainer.ARM
        );
    }
}
