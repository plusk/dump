videoer = [
'https://www.youtube.com/watch?v=dQw4w9WgXcQ',
'https://www.youtube.com/watch?v=cpPG0bKHYKc',
'https://www.youtube.com/watch?v=hFhiV5X5QM4',
'https://www.youtube.com/watch?v=6r1DFGpBzrc',
'https://www.youtube.com/watch?v=Ow3CcOGNIss',
'https://www.youtube.com/watch?v=z9Uz1icjwrM']
vid = []

for x in range(len(videoer)):
	tempStr = videoer[x]
	tempStr = tempStr.split("=")
	vid.append("youtu.be/" + tempStr[1])
print(vid)