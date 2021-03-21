package org.jxch.study.concurrent.jit;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * 执行结果：
 * Benchmark                                     Mode  Cnt   Score   Error  Units
 * LockEliminationBenchmark.justIPlus            avgt    5   2.458 ± 0.387  ns/op
 * LockEliminationBenchmark.syncLocalLockIPlus   avgt    5   2.513 ± 0.562  ns/op
 * LockEliminationBenchmark.syncStaticLockIPlus  avgt    5  29.883 ± 4.380  ns/op
 *
 * @author jxch
 * @see LockElimination
 * @since 1.8
 */

@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class LockEliminationBenchmark {
    private static final LockElimination benchmark = new LockElimination();

    @Benchmark
    public void justIPlus() {
        benchmark.justIPlus();
    }

    @Benchmark
    public void syncLocalLockIPlus() {
        benchmark.syncLocalLockIPlus();
    }

    @Benchmark
    public void syncStaticLockIPlus() {
        benchmark.syncStaticLockIPlus();
    }
}