import json
import sys
obj = json.load(sys.stdin)
for job in obj["check_runs"]:
    if job["name"] == sys.argv[0]:
        print(job["id"])
        break
