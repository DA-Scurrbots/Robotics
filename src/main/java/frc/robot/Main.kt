package frc.team6502.robot

import edu.wpi.first.wpilibj.RobotBase
import frc.team6502.robot.APrefrences

/**
 * Entry point. DO NOT TOUCH THIS FILE.
 */
class Main() {
//    APrefrences.Setup() //Setup Preferences
    companion object {
        /**
         * Main initialization function. Do not perform any initialization here.
         */
        @JvmStatic
        fun main(args: Array<String>) {
            RobotBase.startRobot(::Robot)
        }
    }
}

