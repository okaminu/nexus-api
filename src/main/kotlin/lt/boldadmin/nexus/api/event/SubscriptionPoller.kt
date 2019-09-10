package lt.boldadmin.nexus.api.event

interface SubscriptionPoller {
    fun pollInNewThread()
}