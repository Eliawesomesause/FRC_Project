package frc.robot.subsystems.wheel;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class WheelConstants {

    private static boolean FOC_ENABLED = true;

    private static final int MOTOR_ID = 1;

    static final TalonFX MOTOR = new TalonFX(MOTOR_ID);

    static final VoltageOut voltageRequest = new VoltageOut(0).withEnableFOC(WheelConstants.FOC_ENABLED);

    private static final InvertedValue INVERTED_VALUE = InvertedValue.CounterClockwise_Positive;

    private static final NeutralModeValue NEUTRAL_MODE_VALUE = NeutralModeValue.Coast;

    private static final double GEAR_RATIO = 1.5;

    static {
        final TalonFXConfiguration config = new TalonFXConfiguration();
        config.Audio.BeepOnBoot = false;
        config.Audio.BeepOnConfig = false;
        config.MotorOutput.Inverted = INVERTED_VALUE;
        config.MotorOutput.NeutralMode = NEUTRAL_MODE_VALUE;
        config.Feedback.SensorToMechanismRatio = GEAR_RATIO;
        MOTOR.getConfigurator().apply(config);
    }


}
