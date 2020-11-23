import json
import sys
obj = json.load(sys.stdin)
for job in obj["check_runs"]:
    if job["name"] == sys.argv[1]:
        print(job[sys.argv[2]])
        break
