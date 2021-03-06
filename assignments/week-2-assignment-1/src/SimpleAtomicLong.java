// Import the necessary Java synchronization and scheduling classes.

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

/**
 * @class SimpleAtomicLong
 *
 * @brief This class implements a subset of the
 *        java.util.concurrent.atomic.SimpleAtomicLong class using a
 *        ReentrantReadWriteLock to illustrate how they work.
 */
class SimpleAtomicLong
{
    /**
     * The value that's manipulated atomically via the methods.
     */
    private long mValue;
    
    /**
     * The ReentrantReadWriteLock used to serialize access to mValue.
     */
    // TODO - replace the null with the appropriate initialization:
    private ReentrantReadWriteLock mRWLock = new ReentrantReadWriteLock();

    /**
     * Creates a new SimpleAtomicLong with the given initial value.
     */
    public SimpleAtomicLong(long initialValue)
    {
        mValue = initialValue;// TODO - you fill in here    
    }

    /**
     * @brief Gets the current value.
     * 
     * @returns The current value
     */
    public long get()
    {
        long value;
        this.mRWLock.readLock().lock();
        value = mValue;
        this.mRWLock.readLock().unlock();
        return value;
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the updated value
     */
    public long decrementAndGet()
    {
        long value;
        this.mRWLock.writeLock().lock();
        value = --mValue;
        this.mRWLock.writeLock().unlock();
        // TODO - you fill in here, using a writeLock()
        return value;
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the previous value
     */
    public long getAndIncrement()
    {
        long value;
        this.mRWLock.writeLock().lock();
        value = ++mValue;
        this.mRWLock.writeLock().unlock();
        // TODO - you fill in here, using a writeLock()
        return value;
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the previous value
     */
    public long getAndDecrement()
    {
        long value;
        this.mRWLock.readLock().lock();
        value = mValue--;
        this.mRWLock.readLock().unlock();        // TODO - you fill in here, using a writeLock()
        return value;
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the updated value
     */
    public long incrementAndGet()
    {
        long value;
        this.mRWLock.readLock().lock();
        value = mValue++;
        this.mRWLock.readLock().unlock();
        // TODO - you fill in here, using a writeLock()
        return value;
    }
}
