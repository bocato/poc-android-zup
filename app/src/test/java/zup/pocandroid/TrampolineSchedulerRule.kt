package zup.pocandroid

import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.functions.Function
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.util.concurrent.Callable

open class TrampolineSchedulerRule : TestRule {
    private val trampolineScheduler = Function<Scheduler, Scheduler> { Schedulers.trampoline() }
    override fun apply(statement: Statement, description: Description): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                RxJavaPlugins.setIoSchedulerHandler(trampolineScheduler)
                RxJavaPlugins.setComputationSchedulerHandler(trampolineScheduler)
                RxJavaPlugins.setNewThreadSchedulerHandler(trampolineScheduler)
                RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

                try {
                    statement.evaluate()
                } finally {
                    RxJavaPlugins.reset()
                    RxAndroidPlugins.reset()
                }
            }
        }
    }

}