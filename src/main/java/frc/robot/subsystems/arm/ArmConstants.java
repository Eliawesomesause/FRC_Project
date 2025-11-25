package frc.robot.subsystems.arm;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Angle;

public class ArmConstants {
    private static final int MOTOR_ID = 1;
    private static final int ENCODER_ID = 1;
    static final TalonFX MOTOR = new TalonFX(MOTOR_ID);
    static final CANcoder ENCODER = new CANcoder(ENCODER_ID);

    static final PIDController PID_CONTROLLER = new PIDController(1, 0, 0);
    static final StatusSignal<Angle> ANGLE_STATUS_SIGNAL = ENCODER.getPosition();
    static final boolean FOC_ENABLED = true;

    static {
        final TalonFXConfiguration configureMotor = new TalonFXConfiguration();
        final CANcoderConfiguration configureEncoder = new CANcoderConfiguration();
        configureMotor.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
        configureMotor.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        ANGLE_STATUS_SIGNAL.setUpdateFrequency(100);
        ENCODER.optimizeBusUtilization();
        MOTOR.getConfigurator().apply(configureMotor);
        ENCODER.getConfigurator().apply(configureEncoder);
    }
}
