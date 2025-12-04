package frc.robot.subsystems.arm;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Angle;

public class ArmConstants {
    private static final int
                    MOTOR_ID =1,
                    ENCODER_ID = 1;
    static final TalonFX MOTOR = new TalonFX(MOTOR_ID);
    static final CANcoder ENCODER = new CANcoder(ENCODER_ID);

    static final PIDController PID_CONTROLLER = new PIDController(1, 0, 0);
    static final StatusSignal<Angle> ANGLE_STATUS_SIGNAL = ENCODER.getPosition();
    static final boolean FOC_ENABLED = true;

    static {
        configureMotor();
        configureEncoder();
    }

    private static void configureMotor() {
        final TalonFXConfiguration configureMotor = new TalonFXConfiguration();
        configureMotor.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
        configureMotor.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        MOTOR.optimizeBusUtilization();
        MOTOR.getConfigurator().apply(configureMotor);
    }

    private static void configureEncoder() {
        final CANcoderConfiguration configureEncoder = new CANcoderConfiguration();
        configureEncoder.MagnetSensor.SensorDirection = SensorDirectionValue.CounterClockwise_Positive;
        configureEncoder.MagnetSensor.AbsoluteSensorDiscontinuityPoint = 0.5;
        configureEncoder.MagnetSensor.MagnetOffset = 0;
        ENCODER.optimizeBusUtilization();
        ENCODER.getConfigurator().apply(configureEncoder);
        ANGLE_STATUS_SIGNAL.setUpdateFrequency(100);
    }

    enum ArmState{
        LOW (21),
        MEDIUM (41),
        HIGH (67);

        public final double targetAngle;

        private ArmState(double targetAngle) {
            this.targetAngle = targetAngle;
        }
    }
}
