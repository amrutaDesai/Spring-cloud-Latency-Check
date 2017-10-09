# Spring-cloud-Latency-Check
Demo for Latency check for micro servies

/*
Systems behave differently under load and at scale. The specification of a system’s behavior often diverges from the actual behavior of the system, and the actual behavior may itself vary in different contexts. It is important to contextualize requests as they transit through a system. It’s also important to be able to talk about the nature of a specific request and to be able to understand that specific request’s behavior relative to the general behavior of similar requests in the past minute, hour, day (or whatever!) other useful interval provides a statistically significant sampling. Context helps us establish whether a request was abnormal and whether it merits attention. You can’t trace bugs in a system until you’ve established a baseline for what normal is. How long is is long? For some systems it might be microseconds, for others it might be seconds or minutes!

Spring Cloud Sleuth which supports distributed tracing, can help us establish this context and helps us better understand a system’s actual behavior, not just its specified behavior.

Spring cloud Latency check is an example the same, where Basic services with Customer contact details, vehicle details and customer details are 3 different micro services built up woth configuration of zipkin server to trace the requests between each server. 
*/
